package evolv.io;

public interface CreatureSensor {

	public double sense();
	
	public abstract class AbstractCreatureSensor implements CreatureSensor{
		
		protected final Creature creature;
		public AbstractCreatureSensor(Creature creature) {
			this.creature = creature;
		}
	}

	public class SeeHue extends AbstractCreatureSensor {
		
		private final Eye eye;
		
		public SeeHue(Creature creature, Eye eye) {
			super(creature);
			this.eye = eye;
		}

		@Override
		public double sense() {
			eye.see();
			return eye.getEyeResult().hue;
		}
	}
	
	public class SeeBrightness extends AbstractCreatureSensor {
		
		private final Eye eye;
		
		public SeeBrightness(Creature creature, Eye eye) {
			super(creature);
			this.eye = eye;
		}

		@Override
		public double sense() {
			eye.see();
			return eye.getEyeResult().brightness;
		}
	}
	
	public class SeeSaturation extends AbstractCreatureSensor {
		
		private final Eye eye;
		
		public SeeSaturation(Creature creature, Eye eye) {
			super(creature);
			this.eye = eye;
		}

		@Override
		public double sense() {
			eye.see();
			return eye.getEyeResult().saturation;
		}
	}
	
	public class CreatureEnergySensor extends AbstractCreatureSensor {
		
		public CreatureEnergySensor(Creature creature) {
			super(creature);
		}

		@Override
		public double sense() {
			return creature.getEnergy();
		}
	}
	
	public class CreatureMouthHueSensor extends AbstractCreatureSensor {
		
		public CreatureMouthHueSensor(Creature creature) {
			super(creature);
		}

		@Override
		public double sense() {
			return creature.getMouthHue();
		}
	}
}
