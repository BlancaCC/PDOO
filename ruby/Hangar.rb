# coding: iso-8859-1
require_relative "WeaponType"
require_relative "Weapon"
require_relative "ShieldBooster"

module Deepspace

  class Hangar

    def initialize(capacity)
      @maxElements = capacity #capacidad máxima del hangar
      @weapons = Array.new # contenedor con las armas del hangar
      @shieldBoosters = Array.new # contenedor con los escudos del hangar
    end

    attr_reader :maxElements, :weapons, :shieldBoosters

    def self.newCopy(h)
      cpy = new(h.maxElements)
			h.weapons.each{ |w|
				cpy.weapons.push(w)
			}
			h.shieldBoosters.each{ |s|
				cpy.shieldBoosters.push(s)
			}
			return cpy 
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
