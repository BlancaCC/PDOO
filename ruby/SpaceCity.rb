# coding: utf-8
require_relative 'SpaceStation'
require_relative 'SuppliesPackage'

module Deepspace

  class SpaceCity < SpaceStation

    def initialize(base, rest)
      newStation base 
      @base = base
      @collaborators = rest
    end

    attr_reader :collaborators

    def fire
      res = super
      @collaborators.each{ |s|
        res += s.fire
      }
      return res
    end

    def protection
      res = super
      @collaborators.each{ |s|
        res += s.protection
      }
      return res
    end

    def setLoot(loot)
      super
      #supuestamente no debería de transformarte por que ya lo es
       return Transformation::NOTRANSFORM
      
    end

  end #SpaceCity

end #Module
