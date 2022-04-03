package com.alexmumo.rickymorty.presentation.home.character.components

/*
@Composable
fun TopBar() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text("RickyMorty")
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.ArrowBack, "back")
                    }
                },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
                elevation = 10.dp
            )
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        },
        drawerContent = {
            Text(
                text = "RickyMorty",
                fontSize = 30.sp,
                color = Color.White
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xff8d6e63)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "RickyMorty App")
            }
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = MaterialTheme.colors.primary
            ) {
            }
        }
    )
}

@Composable
fun BottomBarScaffold() {
    Scaffold(
        bottomBar = { BottomBar() }
    ) {
        Box(
            modifier = Modifier
                .background(Color(0xfffff343a))
                .fillMaxSize()
        )
    }
}

@Composable
fun BottomBar() {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(elevation = 10.dp) {
        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.Favorite, "")
            },
            label = { Text(text = "Favorite") },
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
            }

        )
        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.Person, "")
            },
            label = { Text(text = "Favorite") },
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
            }

        )
        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.Person, "")
            },
            label = { Text(text = "Favorite") },
            selected = (selectedIndex.value == 2),
            onClick = {
                selectedIndex.value = 2
            }
        )
    }
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar()
}

 */
