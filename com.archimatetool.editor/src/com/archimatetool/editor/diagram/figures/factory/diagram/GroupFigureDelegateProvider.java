package com.archimatetool.editor.diagram.figures.factory.diagram;

import org.eclipse.draw2d.IFigure;

import com.archimatetool.editor.diagram.figures.diagram.GroupFigure;
import com.archimatetool.editor.diagram.figures.factory.AbstractFigureDelegateProvider;

public class GroupFigureDelegateProvider extends AbstractFigureDelegateProvider {
	
	@Override
	public Class<? extends IFigure> providerFor() {
		return GroupFigure.class;
	}

}
