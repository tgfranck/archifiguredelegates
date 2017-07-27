package com.archimatetool.editor.diagram.figuredelegates.elements;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Pattern;

import com.archimatetool.editor.diagram.figuredelegates.AbstractFigureDelegate;
import com.archimatetool.editor.diagram.figures.FigureUtils;
import com.archimatetool.editor.diagram.figures.IDiagramModelObjectFigure;
import com.archimatetool.editor.preferences.IPreferenceConstants;
import com.archimatetool.editor.preferences.Preferences;

public class ValueFigureDelegate extends AbstractFigureDelegate {

	public ValueFigureDelegate(IDiagramModelObjectFigure owner) {
		super(owner);
	}
	
	@Override
	public void drawFigure(Graphics graphics){
        graphics.pushState();
        
        Rectangle bounds = getBounds().getCopy();
        
        if(!isEnabled()) {
            setDisabledState(graphics);
        }
        
        graphics.setBackgroundColor(getFillColor());
        
        Pattern gradient = null;
        if(Preferences.STORE.getBoolean(IPreferenceConstants.SHOW_GRADIENT)) {
            gradient = FigureUtils.createGradient(graphics, bounds, getFillColor());
            graphics.setBackgroundPattern(gradient);
        }

        graphics.fillOval(bounds.x, bounds.y, bounds.width, bounds.height);
        
        if(gradient != null) {
            gradient.dispose();
        }

        // Outline
        graphics.setForegroundColor(getLineColor());
        graphics.drawOval(bounds.x, bounds.y, bounds.width - 1, bounds.height - 1);
        
        graphics.popState();
	}

	@Override
	public void drawShape(Graphics graphics) {
		graphics.pushState();
		
        Rectangle bounds = getBounds().getCopy();
        
        graphics.fillOval(bounds.x, bounds.y, bounds.width, bounds.height);
        
        graphics.drawOval(bounds.x, bounds.y, bounds.width - 1, bounds.height - 1);
        
        graphics.popState();
	}

}
