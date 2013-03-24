package app;

public class GuiThread implements Runnable{
	
	private IGuiMediator mediator;
	
	public GuiThread(IGuiMediator mediator){
		this.mediator = mediator;
	}

	@Override
	public void run() {
		Gui guiModule = new Gui(mediator);
		guiModule.Build();
	}
}
