/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.diagram.figures.elements;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.EllipseAnchor;

import com.archimatetool.editor.diagram.figures.AbstractTextControlContainerFigure;

/**
 * Value Figure
 * 
 * @author Phillip Beauvoir
 */
public class ValueFigure extends AbstractTextControlContainerFigure {

    public ValueFigure() {
        super(TEXT_FLOW_CONTROL);
    }

    @Override
    public ConnectionAnchor getDefaultConnectionAnchor() {
        return new EllipseAnchor(this);
    }

}
