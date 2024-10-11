package Actividad2.PatronesSB.Configuration;

import Actividad2.PatronesSB.AbstractFactory.IDAO_Producto;
import Actividad2.PatronesSB.AbstractFactory.MySQLDB;
import Actividad2.PatronesSB.AbstractFactory.OracleDB;
import Actividad2.PatronesSB.AbstractFactory.PostgresqlDB;

public class DBConfiguration {

    private static IDAO_Producto daoProducto;

    public static void DBConfiguration(String DBMotors){
        switch (DBMotors.toLowerCase()) {
            case "mysql":
                daoProducto = new MySQLDB();
                break;

                case "oracle":
                    daoProducto = new OracleDB();
                    break;

                    case "postgresql":
                        daoProducto = new PostgresqlDB();
                        break;

                        default:
                            throw new UnsupportedOperationException("Unsupported DB Motors: " + DBMotors);
        }
    }

    public static IDAO_Producto getDaoProducto() {
        if (daoProducto == null) {
            throw new IllegalStateException("No se ha podido obtener un DAO de producto");
        }
        return daoProducto;
    }
}
