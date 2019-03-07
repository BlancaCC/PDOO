module Deepspace
  module WeaponType

    class Type
      # consultor power
      attr_reader :power # equivalente a devolver @power

      def initialize ( _power)
        @power= _power
      end # initialize

    end # class Type

    LASER= Type.new(2.0)
    MISSSILE= Type.new(3.0)
    PLASMA= Type.new(4.0)
  end # module weapon
end
