/**
 * generated by Xtext 2.10.0
 */
package org.eclipse.sirius.tests.sample.xtext.ui.labeling;

import com.google.inject.Inject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

/**
 * Provides labels for EObjects.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
 */
@SuppressWarnings("all")
public class StatemachineLabelProvider extends DefaultEObjectLabelProvider {
  @Inject
  public StatemachineLabelProvider(final AdapterFactoryLabelProvider delegate) {
    super(delegate);
  }
}
