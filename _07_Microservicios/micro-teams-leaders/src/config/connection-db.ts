import { DataSource } from "typeorm";
import * as mysql2 from "mysql2"

export const  AppDataSource = new DataSource({
    type: "mysql",
    host: "localhost",
    port: 3307,
    username: "user",
    password: "password",
    database: "riwi_db_meta",
    synchronize: true,
    entities: ["src/entity/**/*.ts"],
    driver: mysql2
})