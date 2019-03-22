module Deepspace

  # @brief representa a las armas de las que puede disponer una estación
  #        espacial para potenciar su energía al disparar
  class Weapon

    def initialize(name, type, uses)
      @name = name
      @type = type
      @uses = uses
    end

    attr_reader :name, :type, :uses

    def self.newCopy(w)
      new(w.name,w.type,w.uses)
    end

    def power
      type.power
    end

    def useIt
      if @uses > 0
        @uses = @uses-1
        return power
      else
        return 1.0
      end
    end

    def to_s
      s = "Atributos de la instancia de Weapon: \n"
      s += "  name: #{name}\n" 
			s += "  type: "
			if type == WeaponType::LASER
				s += "LASER\n"
      elsif type == WeaponType::MISSILE
				s += "MISIL\n"
			else
				s += "PLASMA\n"
			end
      s += "  uses: #{uses}\n"
			return s
    end

    def getUIversion
      WeaponToUI.new(self)
    end

  end #class Weapon
end
