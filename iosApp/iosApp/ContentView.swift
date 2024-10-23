import SwiftUI
import shared

struct ContentView: View {
 
    var body: some View {
        let homeScreen = HomeScreen(viewModel: .init())
        
        NavigationStack{
            homeScreen
                .toolbar {
                    ToolbarItem {
                        Button {
                        } label: {
                            Label("Sources", systemImage: "list.bullet.rectangle")
                                .labelStyle(.titleAndIcon)
                        }
                    }
                
                }
        }.refreshable {
            homeScreen.viewModel.homeViewModel.getMovie()
        }
    }
}
