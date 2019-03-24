#coding: utf-8

require_relative 'SuppliesPackage'
require_relative 'SpaceStation'
require_relative 'Hangar'

module Pruebas
  class SpaceStation
    def self.test
      supplies = Deepspace::SuppliesPackage.new 10, 32, 12
      
      # constructor
      ss = Deepspace::SpaceStation.new "La armada invencible", supplies
      puts ss.to_s

      #Suminitros basicso de hangar
      hangar = Deepspace::Hangar.new

      
    end  #self test 
  end # class SpaceStation
  
end # module 

Pruebas::SpaceStation.test
