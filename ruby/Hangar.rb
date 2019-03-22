# coding: utf-8
require_relative "WeaponType"
require_relative "Weapon"
require_relative "ShieldBooster"

module Deepspace

  class Hangar

    private def initialize(capacity, weapons, shieldBoosters)
      @maxElements = capacity #capacidad máxima del hangar
      @weapons = weapons # contenedor con las armas del hangar
      @shieldBoosters = shieldBoosters # contenedor con los escudos del hangar
    end

    def self.newCapacity(capacity)
      new(capacity,Array.new,Array.new)
    end

    attr_reader :maxElements, :weapons, :shieldBoosters

    def self.newCopy(h)
      new(h.maxElements,h.weapons,h.shieldBoosters)
    end

	def getUIversion
		HangarToUI.new(self)
	end
	
	private
	def spaceAvailable
		if weapons.size + shieldBoosters.size == maxElements
			return false
		end
		return true
	end

	public
	def addWeapon(w)
		if weapons.size + shieldBoosters.size == maxElements
			return false
		else
			weapons.push(w)
			return true
		end
	end
	
	def addShieldBooster(w)
		if weapons.size + shieldBoosters.size == maxElements
			return false
		else
			shieldBoosters.push(w)
		end
	end

	def removeWeapon(w)
		if w>=0 && w < weapons.size
			return weapons.delete_at(w)
		else
			return nil
		end
	end

	def removeShieldBooster(s)
		if s>=0 && s < shieldBoosters.size
			return shieldBoosters.delete_at(s)
		else
			return nil
		end
	end

	def to_s
		s = "Capacidad maxima: #{maxElements}\n"
		s += "Armas en el hangar:\n"
		weapons.each{ |arma|
			s += arma.to_s
		}
		s += "Escudos en el hangar:\n"
		shieldBoosters.each{ |escudo|
			s += escudo.to_s
		}
		return s
	end
		

  end #class Hangar

end #module Deepspace
