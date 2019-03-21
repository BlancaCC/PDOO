module Deepspace

  class Hangar

    private def initialize(capacity, weapons, shieledBoosters)
      @maxElements = capacity
      @weapons = weapons
      @shieldBoosters = shieldBoosters
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
		if w<0 || w >= weapons.size
			return weapons.delete_at(w)
		else
			return nil
		end
	end

	def removeShieldBooster(s)
		if s<0 || s >= shieldBoosters.size
			return shieldBoosters.delete_at(s)
		else
			return nil
		end
	end
		

  end

end
