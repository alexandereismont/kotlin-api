import React, {useState} from "react";
import {Box, Button, Divider, Drawer, IconButton, Link, List, ListItem, ListItemText, Typography} from "@mui/material";
import MenuIcon from '@mui/icons-material/Menu';
import AppBar from '@mui/material/AppBar';
import {useKeycloak} from "@react-keycloak/web";
import {Link as RouterLink} from "react-router-dom";

export const NavBar = () => {
    const [open, setOpen] = useState(false)
    const { keycloak, initialized } = useKeycloak();

    const setDrawerState = (drawerState: boolean) => {
        setOpen(drawerState)
    }

    return(
        <Box>
            <AppBar
              //  color={"inherit"}
                sx={{flexDirection: "row", justifyContent: "space-between", alignItems: "center", backgroundColor: 'rgb(90, 90, 90)'}}
                position={"static"}
            >
                <IconButton
                    onClick={() => setDrawerState(!open)}
                    sx={{mr: 4}}
                >
                    <MenuIcon fontSize={"large"}/>
                </IconButton>
                <Typography variant="h6">
                    Api
                </Typography>
                {keycloak.authenticated ?
                    <Button color="inherit" onClick={() => keycloak.logout()}>Logout</Button>
                    : <Button color="inherit" onClick={() => keycloak.login()}>Login</Button>
                }
            </AppBar>
            <Drawer
                open={open}
                onClose={() => setDrawerState(false)}
            >
                <Divider />
                <List>
                    <ListItem component={RouterLink} to="/data"><ListItemText primary={"Data"}/></ListItem>
                    <ListItem component={RouterLink} to="/css"><ListItemText primary={"Css"}/></ListItem>
                </List>
            </Drawer>
        </Box>
    )
}
