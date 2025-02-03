import React from "react";
import {Card, Grid} from "@mui/material";
import LoginPage from "./LoginPage"
import RegisterPage from "./RegisterPage";
import {Route, Routes} from "react-router-dom";



const AuthenticationPage = () =>{
    return(
        <div>
            <Grid container>
                <Grid className='h-screen overflow-hidden' item xs={7}>
                    <img className='h-full w-full' src='/images/Auth.jpg' alt='Auth'/>
                </Grid>
                <Grid item xs={5}>
                    <div className='px-20 flex flex-col justify-center h-full'>
                        <Card className='card p-8'>
                            <div className='flex flex-col items-center mb-5 space-y-1'>
                                <h1 className='logo'  > FitFusion</h1>
                                <p className='text-center text-sm w-[70&]'>
                                    Connecting Lives . shear and Like Comment
                                </p>
                            </div>
                            <Routes>
                                <Route path='/' element={<LoginPage/>}></Route>
                                <Route path='/login' element={<LoginPage/>}></Route>
                                <Route path='/register' element={<RegisterPage/>}></Route>
                            </Routes>
                        </Card>

                    </div>
                </Grid>

            </Grid>
        </div>
    )
}
export default AuthenticationPage;