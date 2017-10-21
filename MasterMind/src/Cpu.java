

public class Cpu {
		Algorisme algorisme;
		
		public Cpu(Algorisme algorisme) {
			this.algorisme=algorisme;
		}
		
		public Algorisme getalgorisme(){
			return this.algorisme;
		}
		
		public void setalgorisme(Algorisme algorisme) {
			this.algorisme = algorisme;
		}
}
