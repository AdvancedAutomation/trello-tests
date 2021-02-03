package org.example.trello.ui.cucumber.runner;

import java.util.Locale;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableCellTransformer;

import org.example.trello.ui.pages.board.BoardFields;
import org.example.trello.ui.pages.team.TeamFields;

/**
 * Registers parameters types.
 */
public class TypeRegistries implements TypeRegistryConfigurer {

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
