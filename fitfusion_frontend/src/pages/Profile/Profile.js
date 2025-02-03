import React from "react";
import { useParams } from "react-router-dom";
import { Avatar, Box, Button } from "@mui/material";
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import PostCard from "../../components/Post/PostCard";

const tabs = [
    { value: "post", name: "Post" },
    { value: "status", name: "Status" },
    { value: "saved", name: "Save" },
    { value: "report", name: "RePost" },
];
const posts=[1,1,1,1]
const Profile = () => {
    const { id } = useParams();
    const [value, setValue] = React.useState('post');

    const handleChange = (event, newValue) => {
        setValue(newValue);
    };

    return (
        <div className="py-10 w-[90%]">
            <div className="rounded-md">
                <div className="h-[19rem]">
                    <img className="w-full h-full rounded-t-md" src="https://cdn.pixabay.com/photo/2023/10/26/08/24/autumn-8342089_640.jpg"
                         alt=""/>
                </div>
                <div className="px-7 flex justify-between items-start mt-5 h-[5rem]">
                    <Avatar className="transform -translate-y-24" sx={{ width: "10rem", height: "10rem" }} src="https://cdn.pixabay.com/photo/2023/10/26/08/24/autumn-8342089_640.jpg"/>
                    {true ?( <Button sx={{ borderRadius: "25px" }} variant="outlined">Edit Profile</Button>)
                        : (<Button  variant="outlined">Follow</Button>)}
                </div>
                <div>
                    <h1 className="py-1 flex font-bold text-xl">code with zosh</h1>
                    <p className="py-1 flex ">@codewith</p>
                </div>
                <div className="flex gap-5 items-center py-3">
                    <span>41 Posts</span>
                    <span>35 Followers</span>
                    <span>5 Followings</span>
                </div>
                <div className="flex">
                    <p>
                        nvjsnjabgfbbvibiib
                    </p>
                </div>
                <section>
                    <Box sx={{ width: '100%', borderBottom: 1 ,borderColor:"divider",fontSize:"12px" }}>
                        <Tabs sx={{ width: '100%', borderBottom: 1 ,borderColor:"divider",fontSize:"12px" }}
                            value={value} onChange={handleChange} aria-label="wrapped label tabs example">
                            {tabs.map((item) => <Tab value={item.value} label={item.name} wrapped/>)}
                        </Tabs>
                    </Box>

                    {value === "post" ?<div className="space-y-5 w-[100%] py-5 px-20 justify-between">
                        {posts .map((item)=> <div className="border border-slate-100 rounded-md">
                                <PostCard/></div>)}
                    </div>:""}

                </section>
            </div>
        </div>
    );
};

export default Profile;
