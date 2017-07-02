package View_Interfaces;

import Controller_Interfaces.ViewActions;
import Model_Interfaces.IModelGetData;
import View.ViewFacadeFactory;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

/**
 * This factory provides a simple interface for creating views while representing a facade for the view component.
 * <p>
 *     To standardize the interface between the view component and other components like the controller this class
 *     represents a facade for component interaction. Due to the interaction mainly focuses on creating views this
 *     facade simultaneously implements the abstract factory method. In addition to give the factory the management of
 *     all views there is only one instantiation of this class (singleton method).<br>
 *     All created views are based on {@link IView} and could be created through different functions. To simplify the
 *     functions for creating views the factory holds a instance of {@link IModelGetData} on which all views will
 *     operate.
 * </p>
 * <p>
 *     A view component itself has to contain a class implementing this interface. To retain the small linking between
 *     the different components this class provides an API for creating an instance of this facade from a specific
 *     component:
 * </p>
 * <p>
 *     <code>
 *         IViewFacadeFactory myViewFacadeFactory = IViewFacadeFactory.getInstance(<i>IModelGetData</i>);
 *     </code>
 * </p>
 * <p>
 *     For more details look at the specific functions.
 * </p>
 *
 * @author 9045534
 * @version 1.0
 */
public interface IViewFacadeFactory
{

	/**
	 *
	 * @param model
	 * @return
	 */
	public static IViewFacadeFactory getInstance(@NotNull IModelGetData model)
	{
		return ViewFacadeFactory.getInstance(model);
	}

	/**
	 * Creates a {@link IActualStateEditView} for editing the actual state of the current cost estimation based on the
	 * factory's model. Because the view is a dialog it takes as a parameter the parent view that calls this dialog.
	 * @param parentView View from which this dialog should be created. Could be null.
	 * @return The new created view of type {@link IActualStateEditView}
	 */
	public IActualStateEditView createActualStateEditView(@Nullable IView parentView);

	/**
	 * Creates a {@link IAdditionTab} for editing, creating and deleting additions of the current requirement analysis
	 * based on the factory's model. Due to a tab must have a view which it belongs to the needed parameter is here a
	 * {@link IProjectView}. The new tab will be added to the project view.
	 * @param tabView View on which this tab will be added.
	 * @return The new created view of type {@link IAdditionTab}
	 */
	public IAdditionTab createAdditionTab(@NotNull IProjectView tabView);

	/**
	 * Creates a {@link ICostEstimationTab} for editing, calculating and deleting the cost estimation based on the
	 * factory's model. Due to a tab must have a view which it belongs to the needed parameter is here a
	 * {@link IProjectView}. The new tab will be added to the project view.
	 * @param tabView View on which this tab will be added.
	 * @return The new created view of type {@link IAdditionTab}
	 */
	public ICostEstimationTab createCostEstimationTab(@NotNull IProjectView tabView);

	/**
	 * Creates a {@link ICostEstimationEditView} for editing parameters of the cost estimation based on the factory's
	 * model.
	 * @return The new created view of type {@link ICostEstimationEditView}
	 */
	public ICostEstimationEditView createCostEstimationEditView();

	/**
	 * Creates a {@link ICostEstimationShowView} for showing an overview of the cost estimation based on the factory's
	 * model.
	 * @return The new created view of type {@link ICostEstimationShowView}
	 */
	public ICostEstimationShowView createCostEstimationShowView();

	/**
	 * Creates a {@link ICustomerTab} for editing the customer data of the requirement analysis based on the factory's
	 * model. Due to a tab must have a view which it belongs to the needed parameter is here a {@link IProjectView}.
	 * The new tab will be added to the project view.
	 * @param tabView View on which this tab will be added.
	 * @return The new created view of type {@link ICustomerTab}
	 */
	public ICustomerTab createCustomerTab(@NotNull IProjectView tabView);

	/**
	 * Creates a {@link IErrorDialog} for informing the user about an occurred error. Because the view is a dialog it
	 * takes as a parameter the parent view that calls this dialog. The error message is customized to the thrown
	 * exception which caused this dialog.
	 * @param parentView View from which this dialog should be created. Could be null.
	 * @param thrownException Exception which was thrown and should be displayed
	 * @return The new created view of type {@link IErrorDialog}
	 */
	public IErrorDialog createErrorDialog(@Nullable IView parentView, @NotNull Exception thrownException);

	/**
	 * Creates a {@link IErrorDialog} for informing the user about an occurred error. Because the view is a dialog it
	 * takes as a parameter the parent view that calls this dialog. The error message is customized to the thrown
	 * exception which caused this dialog.
	 * @param parentView View from which this dialog should be created. Could be null.
	 * @param thrownException Exception which was thrown and should be displayed
	 * @param placeholderInText Strings with which the placeholder in the message should be replaced. Mostly exception
	 *                          have predefined placeholder depending on their parameters. Please have a look at
	 *                          {@link LanguageAndText.DialogConstants#getViewActionsByPropertyName(String)} for it.
	 * @return The new created view of type {@link IErrorDialog}
	 */
	public IErrorDialog createErrorDialog(@Nullable IView parentView, @NotNull Exception thrownException,
										  @Nullable String[] placeholderInText);

	/**
	 * Creates a {@link IErrorDialog} for informing the user about an occurred error. Because the view is a dialog it
	 * takes as a parameter the parent view that calls this dialog. The error message and title are given as a
	 * parameter.
	 * @param parentView View from which this dialog should be created. Could be null.
	 * @param title Title of the error dialog which is displayed
	 * @param message Message/Description of the error shown in the dialog
	 * @return The new created view of type {@link IErrorDialog}
	 */
	public IErrorDialog createErrorDialog(@Nullable IView parentView, @NotNull String title,
										  @NotNull String message);

	/**
	 * Creates a {@link IFileChooser} for selecting a file path. Because the view is a dialog it
	 * takes as a parameter the parent view that calls this dialog. The view will be customized to the given
	 * {@link FileAccessType} for which this view is called.
	 * @param parentView View from which this dialog should be created. Could be null.
	 * @param accessType The reason for selecting the file (open, save, etc.)
	 * @return The new created view of type {@link IFileChooser}
	 */
	public IFileChooser createFileChooser(@Nullable IView parentView, @NotNull FileAccessType accessType);

	/**
	 * Creates a {@link IFRequirementEditView} for adding a new functional requirement. Due to editing and adding a
	 * functional requirement requires the same functionality of the view an edit view is created with empty initialized
	 * fields.
	 * @return The new created view of type {@link IFRequirementEditView}
	 */
	public IFRequirementEditView createIFRequirementAddView();

	/**
	 * Creates a {@link IFRequirementEditView} for adding a new functional requirement. For initialization of the fields
	 * the ID of the belonging requirement is needed.
	 * @param ID ID of the functional requirement which should be edited
	 * @return The new created view of type {@link IFRequirementEditView}
	 */
	public IFRequirementEditView createIFRequirementEditView(@NotNull String ID);

	/**
	 * Creates a {@link IFRequirementShowView} to present the saved data of a functional requirement to the user.
	 * The shown requirement is selected by the ID as parameter.
	 * @param ID ID of the functional requirement which should be edited
	 * @return The new created view of type {@link IFRequirementShowView}
	 */
	public IFRequirementShowView createIFRequirementShowView(@NotNull String ID);

	/**
	 * Creates a {@link INFRequirementEditView} for adding a new nonfunctional requirement. Due to editing and adding a
	 * nonfunctional requirement requires the same functionality of the view an edit view is created with empty initialized
	 * fields.
	 * @return The new created view of type {@link INFRequirementEditView}
	 */
	public INFRequirementEditView createINFRequirementAddView();

	/**
	 * Creates a {@link INFRequirementEditView} for adding a new nonfunctional requirement. For initialization of the fields
	 * the ID of the belonging requirement is needed.
	 * @param ID ID of the nonfunctional requirement which should be edited
	 * @return The new created view of type {@link INFRequirementEditView}
	 */
	public INFRequirementEditView createINFRequirementEditView(@NotNull String ID);

	/**
	 * Creates a {@link INFRequirementShowView} to present the saved data of a nonfunctional requirement to the user.
	 * The shown requirement is selected by the ID as parameter.
	 * @param ID ID of the functional requirement which should be edited
	 * @return The new created view of type {@link INFRequirementShowView}
	 */
	public INFRequirementShowView createINFRequirementShowView(@NotNull String ID);

	/**
	 * Creates a {@link IOptimizedWeightFactorsView} to present the user the new optimized weight factors.
	 * @return The new created view of type {@link IOptimizedWeightFactorsView}
	 */
	public IOptimizedWeightFactorsView createOptimizedWeightFactorsView();

	/**
	 * Creates a {@link IProductDataEditView} for adding a new product data. Due to editing and adding a product data
	 * requires the same functionality of the view an edit view is created with empty initialized fields.
	 * @return The new created view of type {@link IProductDataEditView}
	 */
	public IProductDataEditView createProductDataAddView();

	/**
	 * Creates a {@link IProductDataEditView} for adding a new product data. For initialization of the fields
	 * the ID of the belonging requirement is needed.
	 * @param ID ID of the product data which should be edited
	 * @return The new created view of type {@link IProductDataEditView}
	 */
	public IProductDataEditView createProductDataEditView(@NotNull String ID);

	/**
	 * Creates a {@link IProductDataShowView} to present the saved data of a product data to the user.
	 * The shown requirement is selected by the ID as parameter.
	 * @param ID ID of the functional requirement which should be edited
	 * @return The new created view of type {@link IProductDataShowView}
	 */
	public IProductDataShowView createProductDataShowView(@NotNull String ID);

	/**
	 * Creates a {@link IFRequirementTab} for editing, creating and deleting functional requirement of the requirement
	 * analysis based on the factory's model. Due to a tab must have a view which it belongs to the needed parameter
	 * is here a {@link IProjectView}. The new tab will be added to the project view.
	 * @param tabView View on which this tab will be added.
	 * @return The new created view of type {@link IFRequirementTab}
	 */
	public IFRequirementTab createFRequirementTab(@NotNull IProjectView tabView);

	/**
	 * Creates a {@link INFRequirementTab} for editing, creating and deleting nonfunctional requirement of the requirement
	 * analysis based on the factory's model. Due to a tab must have a view which it belongs to the needed parameter
	 * is here a {@link IProjectView}. The new tab will be added to the project view.
	 * @param tabView View on which this tab will be added.
	 * @return The new created view of type {@link INFRequirementTab}
	 */
	public INFRequirementTab createNFRequirementTab(@NotNull IProjectView tabView);

	/**
	 * Creates a {@link IProductDataTab} for editing, creating and deleting product data of the requirement
	 * analysis based on the factory's model. Due to a tab must have a view which it belongs to the needed parameter
	 * is here a {@link IProjectView}. The new tab will be added to the project view.
	 * @param tabView View on which this tab will be added.
	 * @return The new created view of type {@link IProductDataTab}
	 */
	public IProductDataTab createProductDataTab(@NotNull IProjectView tabView);

	/**
	 * Creates a {@link IGlossaryTab} for editing, creating and deleting glossary entries of the requirement
	 * analysis based on the factory's model. Due to a tab must have a view which it belongs to the needed parameter
	 * is here a {@link IProjectView}. The new tab will be added to the project view.
	 * @param tabView View on which this tab will be added.
	 * @return The new created view of type {@link IGlossaryTab}
	 */
	public IGlossaryTab createGlossaryTab(@NotNull IProjectView tabView);

	/**
	 * Creates a {@link IProcessClassificationView} for specifying the class type and parameters of a requirement of
	 * the cost estimation. The requirement is chosen by the given ID being the same for functional requirements,
	 * nonfunctional requirements and product data.
	 * @param ID ID of the requirement which should be classified
	 * @return The new created view of type {@link IProcessClassificationView}
	 */
	public IProcessClassificationView createProcessClassificationView(@NotNull String ID);

	/**
	 * Creates a {@link IProductApplicationTab} for editing the product application of the requirement analysis based
	 * on the factory's model. Due to a tab must have a view which it belongs to the needed parameter is here a
	 * {@link IProjectView}. The new tab will be added to the project view.
	 * @param tabView View on which this tab will be added.
	 * @return The new created view of type {@link IProductApplicationTab}
	 */
	public IProductApplicationTab createProductApplicationTab(@NotNull IProjectView tabView);

	/**
	 * Creates a {@link IProductEnvironmentTab} for editing the product environment of the requirement analysis based
	 * on the factory's model. Due to a tab must have a view which it belongs to the needed parameter is here a
	 * {@link IProjectView}. The new tab will be added to the project view.
	 * @param tabView View on which this tab will be added.
	 * @return The new created view of type {@link IProductEnvironmentTab}
	 */
	public IProductEnvironmentTab createProductEnvironmentTab(@NotNull IProjectView tabView);

	/**
	 * Creates a {@link IProjectCreateView} for creating a new requirement analysis.
	 * @return The new created vuew of type {@link IProjectCreateView}
	 */
	public IProjectCreateView createProjectCreateView();

	/**
	 * Creates a {@link IProjectTab} for basic functionality like saving based on the factory's model. Due to a tab
	 * must have a view which it belongs to the needed parameter is here a {@link IProjectView}. The new tab will be
	 * added to the project view.
	 * @param tabView View on which this tab will be added.
	 * @return The new created view of type {@link IProjectTab}
	 */
	public IProjectTab createProjectTab(@NotNull IProjectView tabView);

	/**
	 * Creates a {@link IProjectView} which builds the basic structure for editing requirement analysis. The
	 * functionality of this view is extended by tabs which could be added.
	 * @return The new created view of type {@link IProjectView}
	 * @see IViewFacadeFactory#createAdditionTab(IProjectView)
	 * @see IViewFacadeFactory#createCostEstimationTab(IProjectView)
	 * @see IViewFacadeFactory#createCustomerTab(IProjectView)
	 * @see IViewFacadeFactory#createFRequirementTab(IProjectView)
	 * @see IViewFacadeFactory#createNFRequirementTab(IProjectView)
	 * @see IViewFacadeFactory#createProductDataTab(IProjectView)
	 * @see IViewFacadeFactory#createGlossaryTab(IProjectView)
	 * @see IViewFacadeFactory#createProductApplicationTab(IProjectView)
	 * @see IViewFacadeFactory#createProductEnvironmentTab(IProjectView)
	 * @see IViewFacadeFactory#createProjectTab(IProjectView)
	 * @see IViewFacadeFactory#createQualityRequirementTab(IProjectView)
	 * @see IViewFacadeFactory#createTargetDefinitionTab(IProjectView)
	 */
	public IProjectView createProjectView();

	/**
	 * Creates a {@link IQualityRequirementTab} for editing, creating and deleting quality requirements of the requirement
	 * analysis based on the factory's model. Due to a tab must have a view which it belongs to the needed parameter
	 * is here a {@link IProjectView}. The new tab will be added to the project view.
	 * @param tabView View on which this tab will be added.
	 * @return The new created view of type {@link IQualityRequirementTab}
	 */
	public IQualityRequirementTab createQualityRequirementTab(@NotNull IProjectView tabView);

	/**
	 * Creates a {@link IStartView} as a start view of this application.
	 * @return The new created view of type {@link IStartView}
	 */
	public IStartView createStartView();

	/**
	 * Creates a {@link ITargetDefinitionTab} for editing the target definition of the requirement analysis based
	 * on the factory's model. Due to a tab must have a view which it belongs to the needed parameter is here a
	 * {@link IProjectView}. The new tab will be added to the project view.
	 * @param tabView View on which this tab will be added.
	 * @return The new created view of type {@link ITargetDefinitionTab}
	 */
	public ITargetDefinitionTab createTargetDefinitionTab(@NotNull IProjectView tabView);

	/**
	 * Creates a {@link IWarningDialog} for warn the user about a consequence of the action he want to take.
	 * Because the view is a dialog it takes as a parameter the parent view that calls this dialog.
	 * The dialog title and message is specified by a property name matching to {@link LanguageAndText.DialogConstants}.
	 * @param parentView View from which this dialog should be created. Could be null.
	 * @param dialogPropertyName Property tag of {@link LanguageAndText.DialogConstants} under which title and message
	 *                           of this warning is saved in the resource files.
	 * @return The new created view of type {@link IWarningDialog}
	 * @see LanguageAndText.DialogConstants
	 */
	public IWarningDialog createWarningDialog(@Nullable IView parentView, @NotNull String dialogPropertyName);

	/**
	 * Creates a {@link IWarningDialog} for warn the user about a consequence of the action he want to take.
	 * Because the view is a dialog it takes as a parameter the parent view that calls this dialog.
	 * The dialog title and message is specified by a property name matching to {@link LanguageAndText.DialogConstants}.
	 * To customize the message further placeholder could be chosen (see {@link LanguageAndText.ITextFacade} for details).
	 * @param parentView View from which this dialog should be created. Could be null.
	 * @param dialogPropertyName Property tag of {@link LanguageAndText.DialogConstants} under which title and message
	 *                           of this warning is saved in the resource files.
	 * @param placeholderInText Strings with which the placeholder in the message should be replaced
	 * @return The new created view of type {@link IWarningDialog}
	 * @see LanguageAndText.DialogConstants
	 */
	public IWarningDialog createWarningDialog(@Nullable IView parentView, @NotNull String dialogPropertyName,
											  @Nullable String[] placeholderInText);

	/**
	 * Creates a {@link IWarningDialog} for warn the user about a consequence of the action he want to take.
	 * Because the view is a dialog it takes as a parameter the parent view that calls this dialog.
	 * The dialog title and message are given as parameter too.
	 * @param parentView View from which this dialog should be created. Could be null.
	 * @param warnTitle Title which should be displayed in the dialog
	 * @param warnDescription Message/Description of the warning which is displayed
	 * @return The new created view of type {@link IWarningDialog}
	 */
	public IWarningDialog createWarningDialog(@Nullable IView parentView, @NotNull String warnTitle,
											  @NotNull String warnDescription);

	/**
	 * Creates a {@link IWarningDialog} for warning the user about a consequence of the action he want to take.
	 * Because the view is a dialog it takes as a parameter the parent view that calls this dialog.
	 * The dialog title and message are given as parameter too. For further customization of the dialog the possible
	 * button actions are variable as parameters of type {@link ViewActions}.
	 * @param parentView View from which this dialog should be created. Could be null.
	 * @param warnTitle Title which should be displayed in the dialog
	 * @param warnDescription Message/Description of the warning which is displayed
	 * @param warnButtonActions Actions of buttons in this dialog
	 * @return The new created view of type {@link IWarningDialog}
	 * @see ViewActions
	 */
	public IWarningDialog createWarningDialog(@Nullable IView parentView, @NotNull String warnTitle,
											  @NotNull String warnDescription,
											  @NotNull ViewActions[] warnButtonActions);

	/**
	 * Creates a {@link IInfoDialog} for informing the user about an event. Because the view is a dialog it takes
	 * as a parameter the parent view that calls this dialog.
	 * The dialog title and message is specified by a property name matching to {@link LanguageAndText.DialogConstants}.
	 * @param parentView View from which this dialog should be created. Could be null.
	 * @param dialogPropertyName Property tag of {@link LanguageAndText.DialogConstants} under which title and message
	 *                           of this warning is saved in the resource files.
	 * @return The new created view of type {@link IInfoDialog}
	 * @see LanguageAndText.DialogConstants
	 */
	public IInfoDialog createInfoDialog(@Nullable IView parentView, @NotNull String dialogPropertyName);

	/**
	 * Creates a {@link IInfoDialog} for informing the user about an event. Because the view is a dialog it takes
	 * as a parameter the parent view that calls this dialog.
	 * The dialog title and message is specified by a property name matching to {@link LanguageAndText.DialogConstants}.
	 * To customize the message further placeholder could be chosen (see {@link LanguageAndText.ITextFacade} for details).
	 * @param parentView View from which this dialog should be created. Could be null.
	 * @param dialogPropertyName Property tag of {@link LanguageAndText.DialogConstants} under which title and message
	 *                           of this warning is saved in the resource files.
	 * @param placeholderInText Strings with which the placeholder in the message should be replaced
	 * @return The new created view of type {@link IInfoDialog}
	 * @see LanguageAndText.DialogConstants
	 */
	public IInfoDialog createInfoDialog(@Nullable IView parentView, @NotNull String dialogPropertyName,
										@Nullable String[] placeholderInText);

	/**
	 * Creates a {@link IInfoDialog} for informing the user about an event. Because the view is a dialog it takes
	 * as a parameter the parent view that calls this dialog. The dialog title and message are given as parameters too.
	 * @param parentView View from which this dialog should be created. Could be null.
	 * @param infoTitle Title of the dialog which is displayed
	 * @param infoMessage Message/Information which is shown
	 * @return The new created view of type {@link IInfoDialog}
	 * @see LanguageAndText.DialogConstants
	 */
	public IInfoDialog createInfoDialog(@Nullable IView parentView, @NotNull String infoTitle,
										@NotNull String infoMessage);

	/**
	 * Creates a {@link ILoadingDialog} for informing the user about loading activities. Because the view is a dialog it
	 * takes as a parameter the parent view that calls this dialog.
	 * @param parentView View from which this dialog should be created. Could be null.
	 * @return The new created view of type {@link ILoadingDialog}
	 */
	public ILoadingDialog createLoadingDialog(@Nullable IView parentView);

	/**
	 * Creates a {@link IWeightFactorEditView} for editing and adjusting the weight factors of the cost estimation.
	 * @return The new created view of type {@link IWeightFactorEditView}
	 */
	public IWeightFactorEditView createWeightFactorEditView();

}
