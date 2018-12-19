package org.fundacionjala.trello.cucumber.runner;

import java.util.Locale;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableCellTransformer;
import org.fundacionjala.trello.pages.BoardFields;
import org.fundacionjala.trello.pages.TeamFields;

/**
 * Registers parameters types.
 */
public class ParameterTypes implements TypeRegistryConfigurer {

    /**
     * {@inheritDoc}
     */
    public Locale locale() {
        return Locale.ENGLISH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void configureTypeRegistry(final TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(BoardFields.class,
                (TableCellTransformer<BoardFields>) cell -> BoardFields.valueOf(cell.toUpperCase())));
        typeRegistry.defineDataTableType(new DataTableType(TeamFields.class,
                (TableCellTransformer<TeamFields>) cell -> TeamFields.valueOf(cell.toUpperCase())));
    }
}
