import SwiftUI
import shared

struct HomeHorizontalPager: View {
    
    let segments: [TabItem] = [TabItem.nowPlaying, TabItem.popular, TabItem.topRated]
    @State var carousselMovie: [Movie] = []
    var nowMovie: [Movie]
    var popularMovie: [Movie]
    var topMovie: [Movie]
    @State private var currentSegment = TabItem.nowPlaying

    init(nowMovie: [Movie], popularMovie: [Movie], topMovie: [Movie]) {
        self.nowMovie = nowMovie
        self.popularMovie = popularMovie
        self.topMovie = topMovie
//        _currentSegment = State(initialValue: .nowPlaying) // Inicializa o segmento atual
        _carousselMovie = State(initialValue: nowMovie) // Inicializa o carousselMovie com nowMovie
    }
    
    var body: some View {
        VStack {
            SegmentedView(segments: segments, selected: $currentSegment)
            Spacer()
            GridLayout(carousselMovie: $carousselMovie)
        }
        .onChange(of: currentSegment) { newSegment in
            switch newSegment {
            case .nowPlaying:
                carousselMovie = nowMovie
            case .popular:
                carousselMovie = popularMovie
            case .topRated:
                carousselMovie = topMovie
            }
        }
        .onAppear {
            carousselMovie = carousselMovie
        }
    }
}

struct SegmentedView : View {
    
    var segments: [TabItem]
    @Binding var selected: TabItem
    @Namespace var name

    var body: some View {
        HStack(spacing: 0) {
            ForEach(segments, id: \.self) { segment in
                Button {
                    selected = segment
                } label: {
                    VStack {
                        Text(segment.title)
                            .foregroundColor(selected == segment ? .green : Color(uiColor: .systemGray))
                        ZStack {
                            Capsule()
                                .fill(Color.clear)
                                .frame(height: 4)
                            if selected == segment {
                                Capsule()
                                    .fill(Color.green)
                                    .frame(height: 4)
                                    .matchedGeometryEffect(id: "Tab", in: name)
                            }
                        }
                    }
                }
            }
        }
    }
}

struct GridLayout: View {
    let columns = [
        GridItem(.flexible(), spacing: 16),
        GridItem(.flexible(), spacing: 16),
        GridItem(.flexible(), spacing: 16)
    ]
    @Binding var carousselMovie: [Movie]
    
    var body: some View {
          ScrollView {
              LazyVGrid(columns: columns, spacing: 16) {
                  ForEach(carousselMovie, id: \.self) { image in
                      NavigationLink(value: 12) {
                          MovieCard(title: image.title, imageName: image.posterPath)
                      }
                      .navigationDestination(for: Int.self) { id in
                          DetailScreen(viewModel: .init(), id: id)
                      }
                  }
              }
              .padding(16)
          }
      }
}

struct MovieCard: View {
    var title: String
    var imageName: String
    
    var body: some View {
        VStack {
            AsyncImage(url: URL(string: imageName)) { image in
                if image.image != nil {
                    image.image!
                        .resizable()
                        .scaledToFill()
                        .frame(maxWidth: .infinity, maxHeight: .infinity)
                        .cornerRadius(25)
                        .clipped()
                        .overlay(
                            alignment: .bottomLeading,
                            content: {
                                HStack {
                                    Text(title)
                                        .bold()
                                        .foregroundColor(Color.white)
                                        .padding()
                                        .cornerRadius(10)
                                        .padding(.bottom, 20)
                                }
                            }
                        )
                } else if image.error != nil {
                    Text("Image Load Error")
                } else {
                    ProgressView()
                }
            }.padding(.horizontal, 10)
        }
        .frame(width: 150)
        .padding(.horizontal, 5)
    }
}

enum TabItem: String {
    case nowPlaying = "Now Playing"
    case popular = "Popular"
    case topRated = "Top Rated"
    
    var title: String {
        return self.rawValue
    }
}

