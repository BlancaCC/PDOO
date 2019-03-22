# coding: utf-8
require_relative 'LootToUI'
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

    def to_s
      "Atributos de la instancia de Loot: \n" +
      "  nSupplies: #{nSupplies}\n" +
      "  nWeapons: #{nWeapons}\n" +
      "  nShields: #{nShields}\n" +
      "  nHangars: #{nHangars}\n" +
      "  nMedals: #{nMedals}\n"
    end

    #t
    def getUIversion
      LootToUI.new self 
    end #LootToUIgetVersion
  end #Loot

end
