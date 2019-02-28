# coding: utf-8

=begin
@file SuppliesPackage.rb
@brief La clase SuppliesPackage epresenta a un paquete de suministros para una
 estación espacial. Puede contener armamento, combustible y/o energía para los escudos.
=end

class SuppliesPackage

  def initialize(ammoPower, fuelUnits, shieldPower)
    @ammoPower = ammoPower
    @fuelUnits = fuelUnits
    @shieldPower = shieldPower
  end   # initialize

  attr_reader :ammoPower, :fuelUnits, :shieldPower

  def self.newCopy(otro)
    new(otro.ammoPower, otro.fuelUnits, otro.shieldPower)
  end   # self.newCopy

  end
