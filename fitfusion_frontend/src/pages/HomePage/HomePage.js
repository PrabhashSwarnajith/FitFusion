import React from "react";
import Grid from "@mui/material/Grid";
import { Route, Routes, useLocation } from "react-router-dom";
import MiddlePart from "../../components/MiddlePart/MiddlePart";
import Profile from "../Profile/Profile";
import HomeRight from "../../components/HomeRight/HomeRight";
import Sidebar from "../../components/SideBar/Sidebar";

const HomePage = () => {
    // Access the current location
    const location = useLocation();
    console.log("Current Pathname:", location.pathname); // Log current pathname for debugging

    return (
        <div className="px-20">
            <Grid container spacing={0}>
                 {/*Sidebar */}
                <Grid item xs={12} lg={3}>
                    <div className="sticky top-0">
                        <Sidebar />
                    </div>
                </Grid>
                <Grid item xs={12} lg={6} className="px-5 flex justify-center">
                    <Routes>
                        <Route path="/" element={<MiddlePart />} />
                        <Route path='/profile/:id' element={<Profile/>}/>
                    </Routes>
                </Grid>
                {location.pathname === "/" && (
                    <Grid item xs={12} lg={3} className="relative">
                        <HomeRight/>
                    </Grid>
                )}
            </Grid>
        </div>
    );
};

export default HomePage;
