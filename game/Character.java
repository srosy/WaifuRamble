package game;

import javax.swing.ImageIcon;

/**
 * Character creates character object functionality required for game
 * WaifuRamble.
 * 
 * @author SpencerR
 *
 */
public class Character {

	public final String name;
	public int health;
	private final String meleeAttack;
	private final String rangedAttack;
	private final String defend;

	private final int meleeDamage;
	private int rangeDamage;
	public boolean isDead;
	public final ImageIcon characterImage;

	/**
	 * Constructs a character object using a character builder.
	 * 
	 * @param builder
	 */
	private Character(Builder builder) {
		this.name = builder.name;
		this.health = builder.health;
		this.meleeAttack = builder.meleeAttack;
		this.rangedAttack = builder.rangedAttack;
		this.defend = builder.defend;
		this.meleeDamage = 10;
		this.rangeDamage = 50;
		this.isDead = false;
		this.characterImage = builder.characterImage;
	}

	/**
	 * Damages the designated character, with the damageType.
	 * 
	 * @param character
	 * @param damageType
	 * @return
	 */
	public int damage(Character character, int damageType) {
		character.health -= damageType;

		if (character.health <= 0)
			character.isDead = true;
		return character.health;
	}

	/**
	 * Attacks the charcterDamaged with a melee type attack.
	 * 
	 * @param characterAttacking
	 * @param characterDamaged
	 * @return
	 */
	public String meleeAttack(Character characterAttacking, Character characterDamaged) {
		damage(characterDamaged, meleeDamage);
		return characterAttacking.name + " attacks " + characterDamaged.name;
	}

	/**
	 * Attacks the character with a ranged type attack.
	 * 
	 * @param character
	 * @return
	 */
	public String rangedAttack(Character character) {
		damage(character, rangeDamage);
		return "range attacks " + character.name;
	}

	/**
	 * Procures generic toString.
	 */
	@Override
	public String toString() {
		return "Character [name=" + name + ", health=" + health + ", meleeAttack=" + meleeAttack + ", rangedAttack="
				+ rangedAttack + ", defend=" + defend + ", meleeDamage=" + meleeDamage + ", isDead=" + isDead + "]";
	}

	/**
	 * Class Builder creates a builder object with given properties to help in
	 * creation of Character objects.
	 * 
	 * @author Owner
	 *
	 */
	public static class Builder {
		private String name;
		private int health;
		private String meleeAttack;
		private String rangedAttack;
		private String defend;
		private ImageIcon characterImage;

		/**
		 * Names the character being built.
		 * 
		 * @param name
		 * @return
		 */
		public Builder name(final String name) {
			this.name = name;
			return this;
		}

		/**
		 * Sets the health for the character being built.
		 * 
		 * @param health
		 * @return
		 */
		public Builder health(final int health) {
			this.health = health;
			return this;
		}

		/**
		 * Sets name for meleeAttack of character being built.
		 * 
		 * @param meleeAttack
		 * @return
		 */
		public Builder meleeAttack(final String meleeAttack) {
			this.meleeAttack = meleeAttack;
			return this;
		}

		/**
		 * Sets name for rangedAttack of character being built.
		 * 
		 * @param rangedAttack
		 * @return
		 */
		public Builder rangedAttack(final String rangedAttack) {
			this.rangedAttack = rangedAttack;
			return this;
		}

		/**
		 * Sets name for defend of character being built.
		 * 
		 * @param defend
		 * @return
		 */
		public Builder defend(final String defend) {
			this.defend = defend;
			return this;
		}

		/**
		 * Sets the image of the character being built.
		 * 
		 * @param characterImage
		 * @return
		 */
		public Builder characterImage(final ImageIcon characterImage) {
			this.characterImage = characterImage;
			return this;
		}

		/**
		 * Builds the character.
		 * 
		 * @return
		 */
		public Character build() {
			return new Character(this);
		}

		/**
		 * Returns generic toString.
		 */
		@Override
		public String toString() {
			return "Builder [name=" + name + ", health=" + health + ", meleeAttack=" + meleeAttack + ", rangedAttack="
					+ rangedAttack + ", defend=" + defend + "]";
		}

	}

}
