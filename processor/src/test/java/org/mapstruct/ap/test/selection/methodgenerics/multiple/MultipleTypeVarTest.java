/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.selection.methodgenerics.multiple;

import java.util.Collections;
import java.util.Map;

import org.mapstruct.ap.testutil.ProcessorTest;
import org.mapstruct.ap.testutil.WithClasses;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

/**
 * @author Sjaak Derksen
 *
 */
public class MultipleTypeVarTest {

    @ProcessorTest
    @WithClasses( ReturnTypeHasMultipleTypeVarOneGenericMapper.class )
    public void testGenericSourceTypeVarOneGeneric() {

        ReturnTypeHasMultipleTypeVarOneGenericMapper.Source src =
            new ReturnTypeHasMultipleTypeVarOneGenericMapper.Source( 5L );
        ReturnTypeHasMultipleTypeVarOneGenericMapper.Target target =
            ReturnTypeHasMultipleTypeVarOneGenericMapper.INSTANCE.toTarget( src );

        assertThat( target ).isNotNull();
        assertThat( target.getProp() ).isNotNull();
        assertThat( target.getProp() ).containsExactly( entry( "test", 5L ) );
    }

    @ProcessorTest
    @WithClasses( ReturnTypeHasMultipleTypeVarBothGenericMapper.class )
    public void testGenericReturnTypeVarBothGeneric() {

        ReturnTypeHasMultipleTypeVarBothGenericMapper.Pair pair
            = new ReturnTypeHasMultipleTypeVarBothGenericMapper.Pair( "test", 5L );
        ReturnTypeHasMultipleTypeVarBothGenericMapper.Source src =
            new ReturnTypeHasMultipleTypeVarBothGenericMapper.Source( pair );
        ReturnTypeHasMultipleTypeVarBothGenericMapper.Target target =
            ReturnTypeHasMultipleTypeVarBothGenericMapper.INSTANCE.toTarget( src );

        assertThat( target ).isNotNull();
        assertThat( target.getProp() ).isNotNull();
        assertThat( target.getProp() ).containsExactly( entry( "test", 5L ) );
    }

    @ProcessorTest
    @WithClasses( SourceTypeHasMultipleTypeVarBothGenericMapper.class )
    public void testGenericSourceTypeVarBothGeneric() {

        Map<String, Long> map = Collections.singletonMap( "test", 5L );
        SourceTypeHasMultipleTypeVarBothGenericMapper.Source src =
            new SourceTypeHasMultipleTypeVarBothGenericMapper.Source( map );
        SourceTypeHasMultipleTypeVarBothGenericMapper.Target target =
            SourceTypeHasMultipleTypeVarBothGenericMapper.INSTANCE.toTarget( src );

        assertThat( target ).isNotNull();
        assertThat( target.getProp() ).isNotNull();
        assertThat( target.getProp().getFirst() ).isEqualTo( "test" );
        assertThat( target.getProp().getSecond() ).isEqualTo( 5L );

    }

}
