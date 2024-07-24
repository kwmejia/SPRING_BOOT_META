import { Request, Response } from "express";
import { AppDataSource } from "../config/connection-db";
import { TeamLeader } from "../entity/team-leader";

const teamLeaderRepository = AppDataSource.getRepository(TeamLeader);

export async function getAll(req: Request, res: Response){
    try {
        res.json({
            data: await teamLeaderRepository.find()
        })
    } catch (error) {
        res.json({
            error: error.message
        })
    }
}