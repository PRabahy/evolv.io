package evolv.io;

public interface CreatureAction {

	public void doAction(double modifier, double timeStep);
	
	public abstract class AbstractCreatureAction implements CreatureAction {
		final Creature creature;
		
		public AbstractCreatureAction(Creature creature) {
			this.creature = creature;
		}
	}

	public class Accelerate extends AbstractCreatureAction {

		public Accelerate(Creature creature) {
			super(creature);
		}

		@Override
		public void doAction(double amount, double timeStep) {
			creature.accelerate(amount, timeStep);
		}
	}

	public class AdjustHue extends AbstractCreatureAction {
		
		public AdjustHue(Creature creature) {
			super(creature);
		}

		@Override
		public void doAction(double modifier, double timeStep) {
			creature.setHue(Math.abs(modifier) % 1.0f);
		}
	}

	public class AdjustMouthHue extends AbstractCreatureAction {

		public AdjustMouthHue(Creature creature) {
			super(creature);
		}

		@Override
		public void doAction(double modifier, double timeStep) {
			creature.setMouthHue(Math.abs(modifier) % 1.0f);
		}

	}

	public class Eat extends AbstractCreatureAction {

		public Eat(Creature creature) {
			super(creature);
		}

		@Override
		public void doAction(double attemptedAmount, double timeStep) {
			creature.eat(attemptedAmount, timeStep);
		}
	}

	public class Fight extends AbstractCreatureAction {

		public Fight(Creature creature) {
			super(creature);
		}

		@Override
		public void doAction(double amount, double timeStep) {
			creature.fight(amount, timeStep);
		}
	}

	public class None extends AbstractCreatureAction {

		public None(Creature creature) {
			super(creature);
		}

		@Override
		public void doAction(double modifier, double timeStep) {
		}
	}

	public class Reproduce extends AbstractCreatureAction {

		public Reproduce(Creature creature) {
			super(creature);
		}

		@Override
		public void doAction(double modifier, double timeStep) {
			if (modifier <= 0) {
				return; // This creature doesn't want to reproduce
			}
			if (creature.getAge() < Configuration.MATURE_AGE) {
				return; // This creature is too young
			}
			if (creature.getEnergy() <= Configuration.SAFE_SIZE) {
				return; // This creature is too small
			}

			double babySize = Configuration.SAFE_SIZE;
			creature.reproduce(babySize, timeStep);
		}
	}

	public class Rotate extends AbstractCreatureAction {

		public Rotate(Creature creature) {
			super(creature);
		}

		@Override
		public void doAction(double amount, double timeStep) {
			creature.rotate(amount, timeStep);
		}
	}
}
