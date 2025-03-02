import {Router} from "express"
import {getAllPosts,createPost} from "../controllers/post.controller.js"

const router=Router()

// get 
router.get("/getAll",getAllPosts)

// create
router.post("/create",createPost)


// get and create same route / 
// router.route("/")
// .get(getAllPosts)
// .post(createPost)

export default router