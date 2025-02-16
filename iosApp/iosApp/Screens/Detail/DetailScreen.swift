import SwiftUI
import shared

extension DetailScreen {
    
    @MainActor
    class DetailViewModelWrapper: ObservableObject {
        let detailViewModel: DetailViewModel
        
        
        init() {
            detailViewModel = HomeInjector().detailViewModel
            detailState = detailViewModel.detailState.value
        }
        
        @Published var detailState: DetailState
        
        func startObserving() {
            Task {
                for await datailStateS in detailViewModel.detailState {
                    self.detailState = datailStateS
                }
            }
        }
    }
}

struct DetailScreen: View {
    @ObservedObject private(set) var viewModel: DetailViewModelWrapper
    let id: Int

    var body: some View {
        VStack {
            if viewModel.detailState.loading {
                Loader()
            }

            if let error = viewModel.detailState.error {
                ErrorMessage(message: error)
            }

            if(viewModel.detailState.successState != nil) {
                Text(viewModel.detailState.successState?.gender ?? "RODOLFO")
            }

        }.onAppear{
            self.viewModel.startObserving()
        }.background(Color("ColorBackground"))    }
    
}

//#Preview {
//    DetailScreen()
//}
