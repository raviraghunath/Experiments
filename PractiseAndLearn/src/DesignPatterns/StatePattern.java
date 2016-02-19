package DesignPatterns;

public class StatePattern {
	public static void main(String args[]){
		Switch c = new Switch();
		c.On();
		c.On();
		c.Off();
		c.On();
		c.Off();
		c.Off();
	}
}

class Switch{
	OnState oS = new OnState(this);
	OffState oF = new OffState(this);
	state st = oF;

	public state getSt() {
		return st;
	}

	public void setSt(state st) {
		this.st = st;
	}
	
	public void On(){
		st.on();
	}
	public void Off(){
		st.off();
	}
}



interface state {
	void on();

	void off();
}

class OnState implements state {
	Switch sw;
	OnState(Switch sw){
		this.sw=sw;
	}
	@Override
	public void on() {
		System.out.println("Already On");
	}

	@Override
	public void off() {
		System.out.println("Its off now");
		sw.setSt(sw.oF);
	}

}

class OffState implements state {
	Switch sw;
	OffState(Switch sw){
		this.sw=sw;
	}
	@Override
	public void on() {
		System.out.println("Its on now");
		sw.setSt(sw.oS);
	}

	@Override
	public void off() {
		System.out.println("Already off");
	}

}
