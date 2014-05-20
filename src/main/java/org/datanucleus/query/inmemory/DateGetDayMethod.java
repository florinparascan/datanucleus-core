/**********************************************************************
Copyright (c) 2008 Andy Jefferson and others. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Contributors:
    ...
**********************************************************************/
package org.datanucleus.query.inmemory;

import java.util.Calendar;
import java.util.Date;

import org.datanucleus.exceptions.NucleusException;
import org.datanucleus.query.expression.InvokeExpression;

/**
 * Evaluator for the method "{dateExpr}.getDay()".
 */
public class DateGetDayMethod implements InvocationEvaluator
{
    /* (non-Javadoc)
     * @see org.datanucleus.query.evaluator.memory.InvocationEvaluator#evaluate(org.datanucleus.query.expression.InvokeExpression, org.datanucleus.query.evaluator.memory.InMemoryExpressionEvaluator)
     */
    public Object evaluate(InvokeExpression expr, Object invokedValue, InMemoryExpressionEvaluator eval)
    {
        String method = expr.getOperation();

        if (invokedValue == null)
        {
            return Boolean.FALSE;
        }
        if (!(invokedValue instanceof Date))
        {
            throw new NucleusException(eval.getLocaliser().msg("021011", method, invokedValue.getClass().getName()));
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime((Date)invokedValue);
        return Integer.valueOf(cal.get(Calendar.DAY_OF_MONTH));
    }
}