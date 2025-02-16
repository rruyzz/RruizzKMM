import SwiftUI
import shared

struct ContentView: View {
 
    var body: some View {
        let homeScreen = HomeScreen(viewModel: .init())
        
        NavigationStack{
            homeScreen
        }.refreshable {
            homeScreen.viewModel.homeViewModel.refresh()
        }
        .navigationViewStyle(.stack)

    }
}
