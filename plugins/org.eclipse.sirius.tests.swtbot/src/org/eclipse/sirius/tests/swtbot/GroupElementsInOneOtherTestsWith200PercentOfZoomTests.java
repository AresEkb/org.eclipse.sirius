/*******************************************************************************
 * Copyright (c) 2010, 2014 THALES GLOBAL SERVICES.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.tests.swtbot;

import org.eclipse.sirius.tests.swtbot.support.api.business.UIDiagramRepresentation.ZoomLevel;

/**
 * Same tests as in {@link GroupElementsInOneOtherTests} but with 50% of zoom.
 * 
 * @author <a href="mailto:esteban.dugueperoux@obeo.fr">Esteban Dugueperoux</a>
 */
public class GroupElementsInOneOtherTestsWith200PercentOfZoomTests extends GroupElementsInOneOtherTests {

    private String oldFont;

    @Override
    protected void onSetUpAfterOpeningDesignerPerspective() throws Exception {
        super.onSetUpAfterOpeningDesignerPerspective();
        oldFont = changeDefaultFontName("Comic Sans MS");
        editor.zoom(ZoomLevel.ZOOM_200);
        editor.scrollTo(0, 0);

    }

    protected void tearDown() throws Exception {

        // set focus on diagram to allow zoom change
        diagramEditPartBot.select();

        editor.zoomDefault();

        if (oldFont != null) {
            changeDefaultFontName(oldFont);
        }
        super.tearDown();
    }
}
