package com.archimatetool.editor.diagram.figuredelegates;

import com.archimatetool.editor.diagram.figures.IDiagramModelObjectFigure;

public abstract class AbstractFigureDelegateFilter implements IFigureDelegateFilter {

	@Override
	public abstract void apply(IFigureDelegate delegate);
	
	protected IDiagramModelObjectFigure getOwner(IFigureDelegate delegate){
		IDiagramModelObjectFigure result = null;
		if(delegate instanceof AbstractFigureDelegate){
			result = ((AbstractFigureDelegate) delegate).getOwner();
		}
		return result;
	}

}
