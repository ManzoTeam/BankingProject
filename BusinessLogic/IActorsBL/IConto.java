package IActorsBL;

import java.util.Collection;
import Models.MovimentoModel;

	public interface IConto {
		
		public Collection<MovimentoModel> getMovimenti();
		public double getSaldo();
}
