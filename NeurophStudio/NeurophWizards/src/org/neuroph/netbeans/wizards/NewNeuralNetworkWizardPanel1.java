package org.neuroph.netbeans.wizards;

import java.awt.Component;
import javax.swing.event.ChangeListener;
import org.openide.WizardDescriptor;
import org.openide.WizardValidationException;
import org.openide.util.HelpCtx;

public class NewNeuralNetworkWizardPanel1 implements WizardDescriptor.ValidatingPanel {

    /**
     * The visual component that displays this panel. If you need to access the
     * component from this class, just use getComponent().
     */
    private Component component;

    // Get the visual component for the panel. In this template, the component
    // is kept separate. This can be more efficient: if the wizard is created
    // but never displayed, or not all panels are displayed, it is better to
    // create only those which really need to be visible.
    public Component getComponent() {
        if (component == null) {
            component = new NewNeuralNetworkVisualPanel1();
        }
        return component;
    }

    public HelpCtx getHelp() {
        // Show no Help button for this panel:
        return HelpCtx.DEFAULT_HELP;
        // If you have context help:
        // return new HelpCtx(SampleWizardPanel1.class);
    }

    public boolean isValid() {
        // If it is always OK to press Next or Finish, then:
        return true;
        // If it depends on some condition (form filled out...), then:
        // return someCondition();
        // and when this condition changes (last form field filled in...) then:
        // fireChangeEvent();
        // and uncomment the complicated stuff below.
    }

    public final void addChangeListener(ChangeListener l) {
    }

    public final void removeChangeListener(ChangeListener l) {
    }

    // You can use a settings object to keep track of state. Normally the
    // settings object will be the WizardDescriptor, so you can use
    // WizardDescriptor.getProperty & putProperty to store information entered
    // by the user.
    @Override
    public void readSettings(Object settings) {
    }

    @Override
    public void storeSettings(Object settings) {
        ((WizardDescriptor) settings).putProperty("type", NeuralNetworkTypeWizard.forInt(((NewNeuralNetworkVisualPanel1)getComponent()).getNeuralNetworkTypeList().getSelectedIndex()));
        ((WizardDescriptor) settings).putProperty("neural network name", ((NewNeuralNetworkVisualPanel1) getComponent()).getNeuralNetworkNameField().getText().trim());
    }

    @Override
    public void validate() throws WizardValidationException {
        String neuralNetworkName =((NewNeuralNetworkVisualPanel1)getComponent()).getNeuralNetworkNameField().getText();
        if(neuralNetworkName.equals("")){
            throw new WizardValidationException(null, "Invalid input! Neural network name must not be null value!", null);
        }
    }
}

