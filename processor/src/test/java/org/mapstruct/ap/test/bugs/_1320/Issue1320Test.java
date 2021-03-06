/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.bugs._1320;

import org.mapstruct.ap.testutil.IssueKey;
import org.mapstruct.ap.testutil.ProcessorTest;
import org.mapstruct.ap.testutil.WithClasses;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Filip Hrisafov
 */
@IssueKey("1320")
@WithClasses({
    Issue1320Mapper.class,
    Target.class
})
public class Issue1320Test {

    @ProcessorTest
    public void shouldCreateDeepNestedConstantsCorrectly() {
        Target target = Issue1320Mapper.INSTANCE.map( 10 );

        assertThat( target.getAddress() ).isNotNull();
        assertThat( target.getAddress().getCity() ).isNotNull();
        assertThat( target.getAddress().getCity().getCityName() ).isEqualTo( "myCity" );
        assertThat( target.getAddress().getCity().getStateName() ).isEqualTo( "myState" );
    }
}
