/*
 * Copyright 2011 JBoss Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.kie.guvnor.guided.dtable.client.widget.table;

import com.google.gwt.event.shared.EventBus;
import org.kie.guvnor.decoratedgrid.client.widget.AbstractVerticalMergableGridWidget;
import org.kie.guvnor.decoratedgrid.client.widget.ResourcesProvider;
import org.kie.guvnor.guided.dtable.client.widget.table.events.InsertInternalDecisionTableColumnEvent;
import org.kie.guvnor.guided.dtable.client.widget.table.events.SetInternalDecisionTableModelEvent;
import org.kie.guvnor.guided.dtable.model.BaseColumn;
import org.kie.guvnor.guided.dtable.model.GuidedDecisionTable52;

/**
 * A Vertical implementation of MergableGridWidget, that renders columns as erm,
 * columns and rows as rows. Supports merging of cells between rows.
 */
public class VerticalMergableDecisionTableGridWidget extends AbstractVerticalMergableGridWidget<GuidedDecisionTable52, BaseColumn> {

    public VerticalMergableDecisionTableGridWidget( ResourcesProvider<BaseColumn> resources,
                                                    DecisionTableCellFactory cellFactory,
                                                    DecisionTableCellValueFactory cellValueFactory,
                                                    DecisionTableDropDownManager dropDownManager,
                                                    boolean isReadOnly,
                                                    EventBus eventBus ) {
        super( resources,
               cellFactory,
               cellValueFactory,
               dropDownManager,
               isReadOnly,
               eventBus );

        //Wire-up event handlers
        eventBus.addHandler( SetInternalDecisionTableModelEvent.TYPE,
                             this );
        eventBus.addHandler( InsertInternalDecisionTableColumnEvent.TYPE,
                             this );
    }

}
