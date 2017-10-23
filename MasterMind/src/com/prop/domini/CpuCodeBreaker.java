package com.prop.domini;
public class CpuCodeBreaker extends CodeBreaker {
		Algorisme algorisme;
		
		public CpuCodeBreaker(Algorisme algorisme) {
			this.algorisme=algorisme;
		}
		
		public Algorisme getalgorisme(){
			return this.algorisme;
		}
		
		public void setalgorisme(Algorisme algorisme) {
			this.algorisme = algorisme;
		}
}
