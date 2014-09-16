/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.camunda.bpm.engine.impl.cmd;

import org.camunda.bpm.engine.impl.interceptor.Command;
import org.camunda.bpm.engine.impl.interceptor.CommandContext;
import org.camunda.bpm.engine.query.Query;

/**
 * @author Sebastian Menski
 */
public class ExecuteFilterSingleResultCmd extends AbstractExecuteFilterCmd implements Command<Object> {

  public ExecuteFilterSingleResultCmd(String filterId) {
    super(filterId);
  }

  public ExecuteFilterSingleResultCmd(String filterId, Query extendingQuery) {
    super(filterId, extendingQuery);
  }

  public ExecuteFilterSingleResultCmd(String filterId, String extendingQuery) {
    super(filterId, extendingQuery);
  }

  public Object execute(CommandContext commandContext) {
    Query query = getFilterQuery(commandContext);
    return query.singleResult();
  }

}
