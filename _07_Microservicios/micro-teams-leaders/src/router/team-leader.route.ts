import { Router } from "express";
import { getAll } from "../controller/team-leader.controller";

const teamLeaderRouter = Router();

teamLeaderRouter.get("/", getAll)


export default teamLeaderRouter;