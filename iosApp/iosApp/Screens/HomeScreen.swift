import SwiftUI
import shared


extension HomeScreen {
    
    @MainActor
    class HomeViewModelWrapper: ObservableObject {
        let homeViewModel: HomeViewModel
        
        
        init() {
            homeViewModel = HomeInjector().homeViewModel
            homeState = homeViewModel.homeState.value
        }
        
        @Published var homeState: HomeState
        
        func startObserving() {
            Task {
                for await homeStateS in homeViewModel.homeState {
                    self.homeState = homeStateS
                }
            }
        }
    }
}


struct HomeScreen: View {

    @ObservedObject private(set) var viewModel: HomeViewModelWrapper

    var body: some View {
        VStack {
            if viewModel.homeState.loading {
                Loader()
            }

            if let error = viewModel.homeState.error {
                ErrorMessage(message: error)
            }

            if(!(viewModel.homeState.successState?.popularMovies.isEmpty == true)) {
                ScrollView {
                    VStack(alignment: .leading) {
                        Title(title: viewModel.homeState.successState?.title ?? "")
                        HomeSearch(carousselMovie: viewModel.homeState.successState?.popularMovies ?? [])
                        HomeHorizontalPager()
                    }
                }
            }

        }.onAppear{
            self.viewModel.startObserving()
        }.background(Color("ColorBackground"))
    }
}

struct AppBar: View {
    var body: some View {
        Text("Home")
            .font(.largeTitle)
            .fontWeight(.bold)
    }
}

struct HomeItemView: View {
    var movie: Movie

    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            AsyncImage(url: URL(string: movie.posterPath)) { phase in
                if phase.image != nil {
                    phase.image!
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                } else if phase.error != nil {
                    Text("Image Load Error")
                } else {
                    ProgressView()
                }
            }
            Text(movie.title)
                .font(.title)
                .fontWeight(.bold)
        }
        .padding(16)
    }
}

struct Loader: View {
    var body: some View {
        ProgressView()
    }
}

struct ErrorMessage: View {
    var message: String

    var body: some View {
        Text(message)
            .font(.title)
    }
}
