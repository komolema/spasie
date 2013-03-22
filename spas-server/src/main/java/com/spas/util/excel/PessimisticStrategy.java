/*
 * This class implements a pessimistic approach to persisting the data to
 * the database it enforces certain requirements that must be meet before
 * it can persist data to the database, exceptions are thrown at various points
 * if a requirement is not meet
 */

package com.spas.util.excel;

/**
 *
 * @author Dada
 */
public class PessimisticStrategy extends ExcelStrategy{

    @Override
    public void persistToDatabase(ExcelInfo ei) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void buildRelations() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
