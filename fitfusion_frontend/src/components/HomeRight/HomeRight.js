import React from "react";
import Search from "../Search/Search";
import PopularUsers from "./PopularUsers";
import {Card} from "@mui/material";

const popularUsers=[11,1,1,1]
const HomeRight = () =>{

    return(
        <div className='pr-5'>
            <Search/>

            <Card className='p-5'>
                <div className='flex justify-between py-5 items-center'>
                <p className='font-semibold opacity-70'>Suggetion for u</p>
                <p className='text-xs font-semibold opacity-95'>View All</p>
        </div>

    <div className='space-y-2'>
        {popularUsers.map((item)=><PopularUsers/>)}
    </div>
            </Card>
        </div>
    )
}
export default HomeRight;