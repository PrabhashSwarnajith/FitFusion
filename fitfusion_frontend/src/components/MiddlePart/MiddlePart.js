import React, {useState} from "react";
import {Avatar, Card, IconButton} from "@mui/material";
import AddIcon from '@mui/icons-material/Add';
import ArticleIcon from '@mui/icons-material/Article';
import VideocamIcon from '@mui/icons-material/Videocam';
import ImageIcon from '@mui/icons-material/Image';
import Story from "./Story";
import PostCard from "../Post/PostCard";
import CreatePostModal from "../CreatePost/CreatePostModal";


const MiddlePart = () =>{
const [openCreatePostModal,setOpenCreatePostModal]=useState(false);
const  handleCloseCratePostModel=()=>setOpenCreatePostModal(false);

    const story=[11,1,1,1]
    const posts=[11,1,1,1]
    const  handleOpenCreatePostModal =()=>{
        setOpenCreatePostModal(true)
        console.log("open model")
    }
    return(
        <div className='px-20'>
            <section className='flex items-center p-5 rounded-b-md'>
                <div className="flex flex-col items-center mr-4 cursor-pointer">
                    <Avatar
                        sx={{width: "5rem", height: "5rem"}}
                        // src={}
                    >
                        <AddIcon sx={{fontsize: "3rem"}}/>
                    </Avatar>
                    <p>New</p>
                </div>
                {story.map((item)=> <Story/>)}
            </section>

            <Card className="p-5 mt-5">
                <div className='flex justify-between'>
                    <Avatar/>
                    <input onClick={handleOpenCreatePostModal}
                           className='outline-none w-[90%] rounded-full px-5 bg-transparent border-[#3b4054] border'
                           type='text'/>
                </div>
                <div className='flex justify-center space-x-9 mt-5'>
                    <div className='flex items-center'>
                    <IconButton color="primary" onClick={handleOpenCreatePostModal}>
                            <ImageIcon/>
                        </IconButton>
                        <span>
                            Media
                        </span>
                    </div>

                    <div className='flex items-center'>
                        <IconButton color="primary" onClick={handleOpenCreatePostModal}>
                            <VideocamIcon/>
                        </IconButton>
                        <span>
                            Video
                        </span>
                    </div>

                    <div className='flex items-center'>
                        <IconButton color="primary" onClick={handleOpenCreatePostModal}>
                            <ArticleIcon/>
                        </IconButton>
                        <span>
                            Article
                        </span>
                    </div>
                </div>
            </Card>
            <div className='mt-5 space-y-5'>
                {posts.map((item)=> <PostCard/>)}
            </div>
            <div>
                <CreatePostModal handleClose={handleCloseCratePostModel} open={openCreatePostModal}/>
            </div>

        </div>
    )
}
export default MiddlePart;