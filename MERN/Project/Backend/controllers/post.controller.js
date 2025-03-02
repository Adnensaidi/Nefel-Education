import Post from '../models/posts.model.js'

// get all => function that will get all my posts
const getAllPosts=async (req,res)=>{
try {
    const allPosts=await Post.find()

    res.status(200).json(allPosts)

} catch (error) {
    console.error("SOmething wrong !!",error)
}


}

// create one post 
const createPost=async(req,res)=>{
    try {
   // get the object of post {title: "kqhfkjfds",content:"content"}
    const postToAdd=req.body
    console.log("postToAdd",postToAdd)
    // create with mongoose query
    const P= await Post.create(postToAdd)
    /** another way to create const postToAdd=new Post(req.body)  // postToAdd.save() */
    res.status(201).json(P)


    } catch (error) {
        console.error("SOmething wrong !!",error)
    }
}

export{getAllPosts,createPost}