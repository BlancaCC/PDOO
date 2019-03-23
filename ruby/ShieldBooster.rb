
module Deepspace

  # @brief representa a los potenciadores de escudo que pueden tener las estaciones espaciales
  class ShieldBooster

    def initialize(name,boost,uses)
      @name = name
      @boost = boost
      @uses = uses
    end

    attr_reader :name, :boost, :uses


    def self.newCopy(s)
      new(s.name,s.boost,s.uses)
    end

    def useIt
      if(uses>0)
        @uses = uses-1
        return boost
      else
        return 1.0
      end
    end

    def getUIversion
      ShieldToUI.new(self)
    end

    def to_s
      "Atributos de la instancia de ShieldBooster: \n" +
        "  boost: #{boost}\n" +
        "  uses: #{uses}\n"
    end

    def ShieldToUIgetVersion
      Deepspace::ShieldToUI.new self 
    end

    #protected :name # Necesito el consultor para newCopy, pero el guion dice que
    # solo se definan consultores publicos para @boost y @uses

  end #class ShieldBooster

end #module Deepspace
