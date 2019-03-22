module Deepspace

#Representa una nave enemiga
	class EnemyStarShip

		attr_reader :name, :ammoPower, :shieldPower, :loot, :damage

		def initialize(n,a,s,l,d)
			@name = n
			@ammoPower = a
			@shieldPower = s
			@loot = l
			@damage = d
		end

		def self.newCopy(e)
			new(e.name,e.ammoPower,e.shieldPower,e.loot,e.damage)
		end

		def getUIversion
			EnemyToUI.new(self)
		end

		def protection 
			shieldPower
		end

		def fire
			ammoPower
		end

		# Devuelve el resultado que se produce al recibir un disparo de una determinada potencia
		def receiveShot(shot)	
			if shieldPower < shot
				return ShotResult::DONOTRESIST
			else
				return ShotResult::RESIST
			end
		end

		def to_s
			"EnemyStarShip:\n	name: #{name}\n ammoPower: #{ammoPower}\n shieldPower: #{shieldPower}\n " +
			"loot: #{loot}\n damage: #{damage}\n"
		end

	end # class EnemyStarShip

end #module Deepspace
