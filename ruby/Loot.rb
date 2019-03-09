# coding: utf-8
module Deepspace

=begin
  @file Loop.rb
  @brief implementacion de la clase loot representa el botín que se
  obtiene al vencer a una nave enemiga.
=end

  class Loot

    def initialize ( supplies, weapons, shields, hangars, medals)
      @nSupplies = supplies
      @nWeapons = weapons
      @nShields =  shields
      @nHangars = hangars
      @nMedals = medals
    end # initialize

    attr_reader :nSupplies, :nWeapons, :nShields, :nHangars, :nMedals

  end #Loot

end
